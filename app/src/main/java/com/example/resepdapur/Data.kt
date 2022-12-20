package com.example.resepdapur

import com.example.resepdapur.models.Recipe
import com.example.resepdapur.models.Step

object Data {
    fun getAllData () = listOf(Recipe(id = 1, title = "Sego Goreng", img_id = "https://awsimages.detik.net.id/community/media/visual/2022/09/17/resep-nasi-goreng-udang-kemangi_43.jpeg?w=1200",
    user_id = 1, description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        user = "Rheza Firmandha", "120"
        ))

    fun getSteps() = listOf(Step("1", "masak rempah rempah yang telah disiapkan"),
        Step("2", "masak semua bahan sampai berwarna hitam")
        )
}