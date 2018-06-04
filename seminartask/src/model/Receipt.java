/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import integration.ItemDTO;
import java.time.LocalDateTime;
/**
 *
 * @author beibei
 */
/**
 * The receipt of sale.
 */
public class Receipt {
        private final Sale sale;
        /**
         * Creates a new instance.
         *
         * @param sale The sale proved by this receipt.
         */
        public Receipt(Sale sale) {
        this.sale = sale;
    }
     /**
     * Creates a well-formatted string with the entire content of the receipt.
     *
     * @return The well-formatted receipt string.
     */
    public String createReceiptString() {
        StringBuilder builder = new StringBuilder();
        appendLine(builder, "Kvitto");
        endSection(builder);

        builder.append("Tid: ");
        appendLine(builder, sale.getSaleTime().toString());
        endSection(builder);
        
        for(ItemDTO item: sale.getItems())
            listItem(builder,item);
        endSection(builder);

        builder.append("Total Pris: ");
        appendLine(builder, Integer.toString(sale.getRunningTotal()));
        builder.append("Moms: ");
        appendLine(builder, Double.toString(sale.getTotalTaxes()));
        builder.append("Växel: ");
        appendLine(builder, Integer.toString(sale.getChange()));
        endSection(builder);
        
        return builder.toString();
    }

    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }
    
    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }
    
    private void listItem(StringBuilder builder,ItemDTO item){
        builder.append(item.getDescription()).append(" ");
        builder.append(item.getQuantity()).append("st ");
        builder.append(item.getPrice()).append("kr ");
        builder.append(item.getPrice()*item.getQuantity()).append("kr ");   
        builder.append("\n");
    }

    
}

   