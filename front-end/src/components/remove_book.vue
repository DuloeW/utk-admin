<template>
    <div class="main w-10/12 h-10/12 bg-slate-100 rounded-xl overflow-y-scroll relative">
        <RouterLink to="/">
            <BackButton class="absolute top-0 left-0 text-base p-2 text-black m-2" />
        </RouterLink>
        <div class="p-2 w-fit flex justify-center relative mx-auto">
            <input v-model="keyword" type="search" name="" id="" size="50"
                class="text-xs p-4 tracking-[1px] rounded-sm bg-slate-500 border-none outline-none text-white">
            <button @click="filterBook()"
                class="h-3/6 bg-blue-500 rounded-sm text-white absolute right-3 top-3 w-[15%] mt-1 mr-1">cari</button>
        </div>
        <table class="w-full relative">
            <tr>
                <th>No</th>
                <th>Judul Buku</th>
                <th>Kode Buku</th>
                <th>Kategori</th>
                <th class="w-1/12">Delete</th>
            </tr>
            <tr v-for="(book, index) in books" :key="book.id" class="text-center">
                <td>{{ index + 1 }}</td>
                <td>{{ book.judulBuku }}</td>
                <td>{{ book.kodeBuku }}</td>
                <td>{{ book.kategori }}</td>
                <td><button @click="deleteBuku(book.id)"
                        class="px-2 py-1 bg-red-700 text-white tracking-[2px] text-sm rounded-md">Delete</button></td>
            </tr>
            <div v-if="books.length == 0" class="absolute top-0 left-[30%] w-96 h-96 flex justify-center items-center mx-auto">
                <h2 class="text-5xl font-semibold text-slate-500">Buku Kosong</h2>
            </div>
        </table>
    </div>
</template>
<script>
import axios from 'axios';
import { RouterLink } from 'vue-router';
import BackButton from './icons/back_button.vue'
import TrashIcon from '../components/icons/trash_icon.vue'
export default {
    setup() {
        return {
            RouterLink
        }
    },
    components: {
        BackButton,
        TrashIcon
    },
    data() {
        return {
            no: 1,
            isClick: false,
            keyword: '',
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
        deleteBuku(id) {
            axios.delete(`http://localhost:8123/api/v1/buku/delete/${id}`, {
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(response => {
                console.log(response.data)
                this.books = this.books.filter(book => book.id !== id)
            })
                .catch(err => console.log(err))
        },
        filterBook() {
            if (this.keyword === '') {
                return this.getBuku()
            } else {
                return axios.get(`http://localhost:8123/api/v1/buku/get-all/title/${this.keyword}`)
                    .then(response => this.books = response.data)
                    .catch(err => console.log(err))
            }
        }
    },
    mounted() {
        this.getBuku()
    }
}
</script>
<style scoped>
th {
    position: sticky;
    top: 0;
    background: #F1F5F9;
    padding: 10px;
}

td {
    padding: 20px;
    background: #eeeeee;
}

tr {
    border: 10px solid #F1F5F9;
}

.main {
    animation: naik 1s ease-in forwards;
}

@keyframes naik {
    from {
        opacity: 0;
    }

    to {
        opacity: 1;
    }
}
</style>

