package nl.mesander.pdf_to_excel.controllers;

import jakarta.validation.Valid;
import nl.mesander.pdf_to_excel.dtos.input.InvoiceInputDto;
import nl.mesander.pdf_to_excel.dtos.output.InvoiceDto;
import nl.mesander.pdf_to_excel.exceptions.InvalidInputException;
import nl.mesander.pdf_to_excel.services.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import static nl.mesander.pdf_to_excel.helpers.BindingResultHelper.handleBindingResultError;
import static nl.mesander.pdf_to_excel.helpers.UriBuilder.buildUriInvoiceNumber;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    // ALL - CRUD Methods
    @GetMapping(value = "")
    public ResponseEntity<List<InvoiceDto>> getAllInvoices() {
        List<InvoiceDto> dtos = invoiceService.getAllInvoices();

        return ResponseEntity.ok().body(dtos);
    }

    @GetMapping(value = "/{invoiceNumber}")
    public ResponseEntity<InvoiceDto> getInvoiceById(
            @PathVariable("invoiceNumber") String invoiceNumber
    ) {
        InvoiceDto dto = invoiceService.getInvoice(invoiceNumber);

        return ResponseEntity.ok().body(dto);
    }

    @PostMapping(value = "")
    public ResponseEntity<InvoiceDto> createInvoice(
            @Valid
            @RequestBody InvoiceInputDto inputDto,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasFieldErrors()) {
            throw new InvalidInputException(handleBindingResultError(bindingResult));
        } else {
            InvoiceDto dto = invoiceService.createInvoice(inputDto);

            URI uri = buildUriInvoiceNumber(dto);

            return ResponseEntity.created(uri).body(dto);
        }
    }

    @DeleteMapping(value = "/{invoiceNumber}")
    public ResponseEntity<Object> deleteInvoice(
            @PathVariable("invoiceNumber") String invoiceNumber
    ) {
        String confirmation = invoiceService.deleteInvoice(invoiceNumber);

        return ResponseEntity.ok().body(confirmation);
    }
}
