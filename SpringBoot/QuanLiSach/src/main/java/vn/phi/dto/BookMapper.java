package vn.phi.dto;

    @Mapper
    public interface ProductMapper {
        ProductDTO toProductDTO(Product product);

        List<ProductDTO> toProductDTOs(List<Product> products);

        Product toProduct(ProductDTO productDTO);
    }

