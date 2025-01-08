package nl.mesander.pdf_to_excel.services;

import nl.mesander.pdf_to_excel.dtos.input.InvoiceInputDto;
import nl.mesander.pdf_to_excel.dtos.output.InvoiceDto;
import nl.mesander.pdf_to_excel.models.Invoice;
import nl.mesander.pdf_to_excel.repositories.InvoiceRepository;

import java.util.List;

import static nl.mesander.pdf_to_excel.helpers.CopyProperties.copyProperties;

public class InvoiceService {
     private final InvoiceRepository invoiceRepository;

     public InvoiceService(InvoiceRepository invoiceRepository) {
         this.invoiceRepository = invoiceRepository;
     }

     // Transfer Methods
    public static Invoice dtoToInvoice(InvoiceInputDto inputDto) {
         Invoice invoice = new Invoice();

         copyProperties(inputDto, invoice);

         return invoice;
    }

    public static InvoiceDto invoiceToDto(Invoice invoice) {
         InvoiceDto invoiceDto = new InvoiceDto();

         copyProperties(invoice, invoiceDto);

         return invoiceDto;
    }

    // CRUD Methods
    public List<InvoiceDto> getInvoices() {}
    public InvoiceDto getInvoice() {}
    public List<InvoiceDto> getInvoicesByFilter() {}
    public InvoiceDto createInvoice() {}
    public String deleteInvoice() {}
}
