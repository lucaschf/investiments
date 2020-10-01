package tsi.too.investmentcalculation.ext;


import java.text.NumberFormat;

import tsi.too.investmentcalculation.util.LocaleUtils;


public abstract class NumberExt {

    public static String toBrazilianCurrency(final Number number) {
        return NumberFormat.getCurrencyInstance(LocaleUtils.getBrazilianLocale()).format(number);
    }
}