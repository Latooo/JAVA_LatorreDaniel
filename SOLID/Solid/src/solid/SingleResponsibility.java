package solid;

class Invoice {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

class InvoicePrinter {
    public void printInvoice(Invoice invoice) {
        System.out.println("Imprimiendo factura con monto: " + invoice.getAmount());
    }
}

class InvoiceRepository {
    public void saveInvoice(Invoice invoice) {
        System.out.println("Guardando factura con monto: " + invoice.getAmount());
    }
}

public class SingleResponsibility {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.setAmount(100);

        InvoicePrinter printer = new InvoicePrinter();
        InvoiceRepository repository = new InvoiceRepository();

        printer.printInvoice(invoice);
        repository.saveInvoice(invoice);
    }
}
