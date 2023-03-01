<template>
    <div class="w-11/12 h-11/12">
        <div class=" w-full h-full bg-slate-200 rounded-xl overflow-y-scroll relative">
            <BoxBook v-for="book in books" :judul="book.judulBuku" :kode="book.kodeBuku" :kategori="book.kategori.toLowerCase()" :tahunRilis="book.tahunRilis" :deskripsi="book.deskripsi" class="box-buku"/>
            <KategoriBox class="fixed right-4 top-3"/>
        </div>
    </div>
</template>
<script>
import axios from 'axios';
import BoxBook from '../components/box_buku.vue';
import KategoriBox from '../components/kategori_box.vue'
export default {
    components: {
        BoxBook,
        KategoriBox
    },
    data() {
        return {
            books: []
        }
    },
    methods: {
        getBuku() {
            axios.get('http://localhost:8123/api/v1/buku/get-all', {
                headers: {
                    "Content-Type": "application/json"
                }
            })
                .then(response => this.books = response.data)
                .catch(err => console.log(err))
        },
    },
    mounted() {
        this.getBuku()
    }
};
</script>
<style scoped>
.box-buku {
    animation: fade 2s ease-in forwards;
}
@keyframes fade {
    from {
        opacity: 0;
    }
    to {
        opacity: 1;
    }
}
</style>