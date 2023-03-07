<template>
    <div class="main w-10/12 h-10/12 bg-slate-100 rounded-xl overflow-y-scroll relative">
        <RouterLink to="/">
            <BackButton class="absolute top-0 left-0 text-base p-2 text-black m-2"/>
        </RouterLink>
        <div class="">
            <div class="p-2 w-fit flex justify-center relative mx-auto">
                <input  v-model="keyword" @keydown="searchActive" type="search" placeholder="Cari buku...." name="" size="50" id="" class="text-xs p-4 tracking-[1px] rounded-sm bg-slate-500 border-none outline-none text-white">
                <!-- <button @click="filterBook" class="h-3/6 bg-blue-500 rounded-sm text-white absolute right-3 top-3 w-[15%] mt-1 mr-1">cari</button> -->
                <font-awesome-icon v-if="isSearch" @click="searchNotActive" icon="fa-solid fa-xmark" class="absolute right-5 py-2 top-3.5 px-3 bg-red-600 text-center text-xl rounded-md text-white"/>
            </div>
        </div>
        <table class="w-full relative">
            <tr>
                <th>No</th>
                <th>Judul Buku</th>
                <th>Kode Buku</th>
                <th>Kategori</th>
                <th class="w-1/12">Update</th>
            </tr>
            <tr v-for="(book, index) in books" class="text-center ">
                <td>{{ index + 1 }}</td>
                <td>{{ book.judulBuku }}</td>
                <td>{{ book.kodeBuku }}</td>
                <td>{{ book.kategori }}</td>
                <td>
                    <RouterLink :to="`/update-book/${book.id}`">
                        <button class="px-2 py-1 bg-green-700 text-white tracking-[2px] text-sm rounded-md">update</button>
                    </RouterLink>
                </td>
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
export default {
    setup() {
        return {
            RouterLink
        }
    },
    data() {
        return {
            books: [],
            keyword: '',
            isSearch: false
        }
    },
    components: {
        BackButton
    },
    methods: {
        getBook() {
            axios.get('http://localhost:8123/api/v1/buku/get-all', {
                headers: {
                    "Content-Type": "application/json"
                }
            })
                .then(response => this.books = response.data)
                .catch(err => console.log(err))
        },
        filterBook() {
            if (this.keyword === '') {
                return this.getBook()
            } else {
                return axios.get(`http://localhost:8123/api/v1/buku/get-all/title/${this.keyword}`)
                    .then(response => this.books = response.data)
                    .catch(err => console.log(err))
            }
        },
        searchActive() {
            this.isSearch = true
            this.filterBook()
        },
        searchNotActive() {
            this.isSearch = false
            this.keyword = ''
            this.getBook()
        }
    },
    mounted() { 
        this.getBook()
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

input::placeholder {
    letter-spacing: 5px;
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