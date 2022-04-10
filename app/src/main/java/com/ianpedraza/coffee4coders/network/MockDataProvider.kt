package com.ianpedraza.coffee4coders.network

import com.ianpedraza.coffee4coders.models.ProductModel

object MockDataProvider {
    fun listOfProducts(): List<ProductModel> = listOf(
        ProductModel(
            0,
            "Café de Colombia",
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
            "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
            55.0,
            "USD",
            "COL"
        ),
        ProductModel(
            1,
            "Café de Brasil",
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
            "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
            40.0,
            "USD",
            "BRA"
        ),
        ProductModel(
            2,
            "Café de Costa Ríca",
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
            "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
            35.0,
            "USD",
            "CRI"
        ),
        ProductModel(
            3,
            "Café de Nicaragua",
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
            "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text",
            50.0,
            "USD",
            "NIC"
        ),
    )

    fun getProductById(id: Int): ProductModel? = listOfProducts().find { item -> item.id == id }

    fun listOfCities(): List<String> = listOf(
        "Mexico City, Mexico",
        "The Habana, Cuba",
        "Cancun, Mexico",
        "Medellin, Colombia",
        "Buenos Aires, Argentina",
        "Sao Paulo, Brasil",
        "Lima, Peru",
        "Montevideo, Uruguay",
        "Panama City, Panam",
    )

}