package br.com.pet.doc;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.pet.exception.handler.ApiError;
import br.com.pet.model.payload.ClientForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Client Api")
public interface ClienteApi {

	@ApiOperation("Create Cliente")
	@ApiResponses({ @ApiResponse(code = 404, message = "Data not found", response = ApiError.class),
			@ApiResponse(code = 400, message = "Wrong information was sent", response = ApiError.class),
			@ApiResponse(code = 500, message = "An unexpected error occurred", response = ApiError.class) })
	ResponseEntity<?> create(@Valid @RequestBody ClientForm form);

	@ApiOperation("Update Cliente")
	@ApiResponses({ @ApiResponse(code = 404, message = "Data not found", response = ApiError.class),
			@ApiResponse(code = 400, message = "Wrong information was sent", response = ApiError.class),
			@ApiResponse(code = 500, message = "An unexpected error occurred", response = ApiError.class) })
	ResponseEntity<?> update(@RequestBody ClientForm form, @PathVariable Long id);

	@ApiOperation("Delete Cliente")
	@ApiResponses({ @ApiResponse(code = 404, message = "Data not found", response = ApiError.class),
			@ApiResponse(code = 400, message = "Wrong information was sent", response = ApiError.class),
			@ApiResponse(code = 500, message = "An unexpected error occurred", response = ApiError.class) })
	ResponseEntity<?> delete(@PathVariable Long id);

	@ApiOperation("List Clientes")
	@ApiResponses({ @ApiResponse(code = 204, message = "No content", response = ApiError.class),
			@ApiResponse(code = 400, message = "rong information was sent", response = ApiError.class),
			@ApiResponse(code = 500, message = "An unexpected error occurred", response = ApiError.class) })
	ResponseEntity<?> list(Integer page, Integer size);

}
