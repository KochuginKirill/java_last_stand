package Spring.lesson5and6.apiResponses;

import Spring.lesson5and6.rest.ExceptionResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Response {

    @Retention(RetentionPolicy.RUNTIME)
    @ApiResponse(description = "Не найдено", responseCode = "404", content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    public @interface  NotFoundResponse{

    }
}
