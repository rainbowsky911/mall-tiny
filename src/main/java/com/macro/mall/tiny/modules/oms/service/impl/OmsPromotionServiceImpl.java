package com.macro.mall.tiny.modules.oms.service.impl;

import com.macro.mall.tiny.modules.oms.dao.PortalProductDao;
import com.macro.mall.tiny.modules.oms.dto.CartPromotionItem;
import com.macro.mall.tiny.modules.oms.dto.PromotionProduct;
import com.macro.mall.tiny.modules.oms.entity.OmsCartItem;
import com.macro.mall.tiny.modules.oms.service.OmsPromotionService;
import com.macro.mall.tiny.modules.pms.entity.PmsProductFullReduction;
import com.macro.mall.tiny.modules.pms.entity.PmsSkuStock;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OmsPromotionServiceImpl implements OmsPromotionService {

    @Autowired
    private PortalProductDao portalProductDao;

    @Override
    public List<CartPromotionItem> calcCartPromotion(List<OmsCartItem> cartItemList) {

        /**
         * 将商品分组
         */
        Map<Long, List<OmsCartItem>> listMap = groupByCartPromotionId(cartItemList);

        /**
         * 查询优惠信息
         *
         */

        List<PromotionProduct> promotionList = getPromotionList(cartItemList);

        /***
         * 根据商品促销类型计算商品优惠
         *
         */
        List<CartPromotionItem> cartPromotionItemList = new ArrayList<>();
        for (Map.Entry<Long, List<OmsCartItem>> entry : listMap.entrySet()) {
            Long productId = entry.getKey();
            PromotionProduct product = getPromotionProductById(productId, promotionList);
            List<OmsCartItem> itemList = entry.getValue();
            Integer type = product.getPromotionType();
            if (type == 4) {
                System.out.println("yes");
                double amount = getCartItemAmount(itemList, promotionList);
                PmsProductFullReduction pmsProductFullReduction = getProductFullReduction(amount, product.getProductFullReductionList());
                if (pmsProductFullReduction != null) {
                    for (OmsCartItem item : itemList) {

                        CartPromotionItem cartPromotionItem = new CartPromotionItem();
                        BeanUtils.copyProperties(item, cartPromotionItem);
                        String message = getFullReductionPromotionMessage(pmsProductFullReduction);
                        cartPromotionItem.setPromotionMessage(message);
                        PmsSkuStock pmsSkuStock = getOriginalPrice(product, item.getProductSkuId());
                        Double originalPrice = pmsSkuStock.getPrice();
                        double reduceAmount = (originalPrice / amount) * pmsProductFullReduction.getReducePrice();

                        cartPromotionItem.setReduceAmount(new BigDecimal(reduceAmount));
                        cartPromotionItem.setRealStock(pmsSkuStock.getStock() - pmsSkuStock.getLockStock());
                        cartPromotionItem.setIntegration(product.getGiftPoint());
                        cartPromotionItem.setGrowth(product.getGiftGrowth());
                        cartPromotionItemList.add(cartPromotionItem);
                    }
                }
            }

        }
        return cartPromotionItemList;
    }

    /**
     * 获得满减促销信息
     *
     * @param pmsProductFullReduction
     * @return
     */
    private String getFullReductionPromotionMessage(PmsProductFullReduction pmsProductFullReduction) {
        StringBuilder sb = new StringBuilder();
        sb.append("满减优惠：");
        sb.append("满");
        sb.append(pmsProductFullReduction.getFullPrice());
        sb.append("元，");
        sb.append("减");
        sb.append(pmsProductFullReduction.getReducePrice());
        sb.append("元");
        return sb.toString();
    }

    private PmsProductFullReduction getProductFullReduction(double amount, List<PmsProductFullReduction> productFullReductionList) {

        productFullReductionList.sort(new Comparator<PmsProductFullReduction>() {
            @Override
            public int compare(PmsProductFullReduction o1, PmsProductFullReduction o2) {
                return o2.getFullPrice().intValue() - o1.getFullPrice().intValue();
            }
        });

        for (PmsProductFullReduction fullReduction : productFullReductionList) {
            if (amount - fullReduction.getFullPrice() >= 0) {
                return fullReduction;
            }
        }
        return null;
    }


    /**
     * 获得指定商品总价
     *
     * @param itemList
     * @param promotionList
     * @return
     */
    private double getCartItemAmount(List<OmsCartItem> itemList, List<PromotionProduct> promotionList) {
        double amount = 0;
        for (OmsCartItem item : itemList) {
            PromotionProduct promotionProduct = getPromotionProductById(item.getProductId(), promotionList);
            PmsSkuStock skuStock = getOriginalPrice(promotionProduct, item.getProductSkuId());
            amount = skuStock.getPrice() * item.getQuantity();
        }
        return amount;
    }

    /**
     * 获得商品原价
     *
     * @param promotionProduct
     * @param productSkuId
     * @return
     */
    private PmsSkuStock getOriginalPrice(PromotionProduct promotionProduct, Long productSkuId) {

        for (PmsSkuStock skuStock : promotionProduct.getSkuStockList()) {
            if (productSkuId.equals(skuStock.getId())) {

                return skuStock;
            }

        }
        return null;
    }

    /**
     * 根据商品ID查询促销信息
     *
     * @param productId
     * @param promotionProductList
     * @return
     */
    private PromotionProduct getPromotionProductById(Long productId, List<PromotionProduct> promotionProductList) {
        for (PromotionProduct promotionProduct : promotionProductList) {
            if (productId.equals(promotionProduct.getId())) {
                return promotionProduct;
            }
        }
        return null;
    }

    /**
     * 查询所有的优惠商品相关信息
     *
     * @param cartItemList
     * @return
     */
    public List<PromotionProduct> getPromotionList(List<OmsCartItem> cartItemList) {
        List<Long> productIdList = new ArrayList<>();
        for (OmsCartItem cartItem : cartItemList) {
            productIdList.add(cartItem.getProductId());
        }
        return portalProductDao.getPromotionProductList(productIdList);
    }


    /**
     * 以spu为单位对购物车中商品进行分组
     *
     * @param cartItemList
     * @return
     */
    public Map<Long, List<OmsCartItem>> groupByCartPromotionId(List<OmsCartItem> cartItemList) {
        Map<Long, List<OmsCartItem>> cartPromotionMap = new TreeMap<>();

        for (OmsCartItem cartItem : cartItemList) {
            List<OmsCartItem> cartPromotionItemList = cartPromotionMap.get(cartItem.getProductId());
            if (cartPromotionItemList == null) {
                cartPromotionItemList = new ArrayList<>();
                cartPromotionItemList.add(cartItem);
                cartPromotionMap.put(cartItem.getProductId(), cartPromotionItemList);
            } else {
                cartPromotionItemList.add(cartItem);
            }
        }
        return cartPromotionMap;
    }
}
