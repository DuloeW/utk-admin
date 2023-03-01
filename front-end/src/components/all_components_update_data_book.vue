<template>
    <div class="h-full w-full flex justify-around items-center relative gap-2">
        <RouterLink to="/update-book" class="absolute top-0 left-0">
            <BackButton class="text-white" />
        </RouterLink>
        <BoxDataBefore :judul="book.judulBuku" :kode="book.kodeBuku" :kategori="book.kategori" :tahun="book.tahunRilis" :deskripsi="book.deskripsi" />
        <BoxDataAfter />
    </div>
</template>
<script>
import axios from 'axios';
import { RouterLink } from 'vue-router';
import BoxDataAfter from '../components/box_data_book_will_update.vue'
import BoxDataBefore from '../components/box_data_book.vue'
import BackButton from '../components/icons/back_button.vue'
export default {
    setup() {
        return {
            RouterLink
        }
    },
    data() {
        return {
            book: {}
        }
    },
    components: {
        BoxDataAfter,
        BoxDataBefore,
        BackButton
    },
    methods: {
        async getBook() {
            try {
                const response = await axios.get(`http://localhost:8123/api/v1/buku/get/${this.$route.params.id}`)
                this.book = response.data
            } catch (error) {
                console.log(error.response.data);
            }
        } 
    },
    mounted() {
        this.getBook()
    }
}
</script>