package printer;

import com.uniquesecure.meposconnect.*;

public class ReceiptBuilder {

    public MePOSReceipt getShortReceipt() {
        MePOSReceipt receipt = new MePOSReceipt();
        MePOSReceiptTextLine rcpt = new MePOSReceiptTextLine();

        rcpt.setText("RECEIPT", MePOS.TEXT_STYLE_BOLD, MePOS.TEXT_SIZE_NORMAL, MePOS.TEXT_POSITION_CENTER);
        receipt.addLine(rcpt);

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("VAT", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_LEFT);
        receipt.addLine(rcpt);
        receipt.addLine(new MePOSReceiptFeedLine(1));

        receipt.addLine(new MePOSReceiptSingleCharLine('-'));
        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("User's name  " + "  Terminal  " + "  Time stamp", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_CENTER);
        receipt.addLine(rcpt);
        receipt.addLine(new MePOSReceiptSingleCharLine('-'));

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("User name example", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_LEFT);
        receipt.addLine(rcpt);
        receipt.addLine(new MePOSReceiptSingleCharLine('-'));

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("Order No.                   Table No.", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_CENTER);
        receipt.addLine(rcpt);
        receipt.addLine(new MePOSReceiptSingleCharLine('-'));

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("1 Corona                      3.60", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_CENTER);
        receipt.addLine(rcpt);

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("1 Soup of the day             4.55", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_CENTER);
        receipt.addLine(rcpt);

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("1 Sirlon                     12.00", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_CENTER);
        receipt.addLine(rcpt);

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("            price override/discount here", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_CENTER);
        receipt.addLine(rcpt);

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("-Sirlon variants here  +Variant price here", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_CENTER);
        receipt.addLine(rcpt);


        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("-Sirlon edited ingredients/stock here", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_CENTER);
        receipt.addLine(rcpt);

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("-Sirlon notes here", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_CENTER);
        receipt.addLine(rcpt);

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("1 Sorbet                      5.00", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_CENTER);
        receipt.addLine(rcpt);
        receipt.addLine(new MePOSReceiptFeedLine(1));

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("Service charge % set percentage", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_LEFT);
        receipt.addLine(rcpt);
        receipt.addLine(new MePOSReceiptSingleCharLine('-'));

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("Total items in basquet        4", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_CENTER);
        receipt.addLine(rcpt);
        receipt.addLine(new MePOSReceiptFeedLine(1));

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("Total top category 1      Sum of all drinks", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_LEFT);
        receipt.addLine(rcpt);

        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("Total top category 1      Sum of all food", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_LEFT);
        receipt.addLine(rcpt);


        rcpt = new MePOSReceiptTextLine();
        rcpt.setText("Total                        20.65", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_STYLE_NONE, MePOS.TEXT_POSITION_LEFT);
        receipt.addLine(rcpt);
        receipt.addLine(new MePOSReceiptSingleCharLine('-'));
        receipt.addLine(new MePOSReceiptFeedLine(1));

        receipt.addLine(new MePOSReceiptBarcodeLine(MePOS.BARCODE_TYPE_CODE39, "R0926031274"));
        receipt.addLine(new MePOSReceiptTextLine("R0926031274", MePOS.TEXT_STYLE_NONE, MePOS.TEXT_SIZE_NORMAL, MePOS.TEXT_POSITION_CENTER));
        receipt.addLine(new MePOSReceiptFeedLine(1));
        receipt.addLine(new MePOSReceiptSingleCharLine('-'));

        return receipt;
    }

}
