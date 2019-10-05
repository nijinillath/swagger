package com.example.swagger.springBootSwagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.springBootSwagger.model.ProductDetails;


@RestController
@RequestMapping(value = "/product")
@Api(value="onlineProducts", description="Operations pertaining to products in Online Store")
public class ProductController {

	@ApiOperation(value = "View list of available products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDetails> getAllProduct() {
		return new ArrayList<ProductDetails>();
	}

	@ApiOperation(value = "View product details for the skuId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the product details"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/sku/{skuId}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductDetails getProductForSku(@PathVariable("skuId") String skuId) {
		ProductDetails product = new ProductDetails();
		return product;
	}
	
	@ApiOperation(value = "Delete the product for the skuId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted the product"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/sku/{skuId}" }, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean deleteProductForSku(@PathVariable("skuId") String skuId) {
		return true;
	}
	
	@ApiOperation(value = "Add the list of new products")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added the product list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDetails> addProducts(List<ProductDetails> productList) {
		return new ArrayList<ProductDetails>();
	}
	
}
