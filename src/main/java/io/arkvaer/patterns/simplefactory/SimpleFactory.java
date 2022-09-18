package io.arkvaer.patterns.simplefactory;


import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * 简单工厂模式实现
 *
 * @author waver
 */
@Slf4j
public class SimpleFactory {
    double totalPrice = 0;

    double originalPrice = 0;

    int discount = 0;

    private void getOriginalPrice() {
        log.info("{}", "请输入原价:");
        Scanner scanner = new Scanner(System.in);
        originalPrice = scanner.nextDouble();
    }

    private void getDiscountMsg() {
        log.info("{}", "请选择打折额度:");
        log.info("{}", "0: 不打折");
        log.info("{}", "1: 0.8折");
        log.info("{}", "2: 0.7折");
        log.info("{}", "3: 0.5折");
        log.warn("您的选择: ");
    }

    private void getFinalPrice() {
        Scanner scanner = new Scanner(System.in);
        discount = scanner.nextInt();
        switch (discount) {
            case 0 -> totalPrice = originalPrice;
            case 1 -> totalPrice = originalPrice * 0.8;
            case 2 -> totalPrice = originalPrice * 0.7;
            case 3 -> totalPrice = originalPrice * 0.5;
            default -> log.error("输入错误");
        }
        log.info("\n最终的价格是: {}", totalPrice);
    }

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        simpleFactory.getOriginalPrice();
        simpleFactory.getDiscountMsg();
        simpleFactory.getFinalPrice();
    }


}
