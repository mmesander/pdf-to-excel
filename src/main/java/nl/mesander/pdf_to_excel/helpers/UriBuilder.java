package nl.mesander.pdf_to_excel.helpers;

// Imports
import nl.mesander.pdf_to_excel.interfaces.IdentifiableInvoiceNumber;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

public class UriBuilder {
    public static URI buildUriInvoiceNumber(IdentifiableInvoiceNumber uriObject) {
        return URI.create((
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + uriObject.getInvoiceNumber()).toUriString())
                );
    }
}
