package nl.mesander.pdf_to_excel.services;

import nl.mesander.pdf_to_excel.repositories.InvoiceRepository;

public class InvoiceService {
     private final InvoiceRepository invoiceRepository;

     public InvoiceService(InvoiceRepository invoiceRepository) {
         this.invoiceRepository = invoiceRepository;
     }

     // Transfer Methods
}
