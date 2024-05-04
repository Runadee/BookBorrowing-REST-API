package dev.patika.bookborrowing.dto.response.publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherResponse {

    private Long id;
    private String name;
    private int establishmentYear;
}
