package com.patikapaycore.project.models.dtos.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class WriterResponseDto {
    private String writerName;
    private  String writerSurname;
}
