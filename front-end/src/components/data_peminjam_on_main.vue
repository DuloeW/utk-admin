<template>
    <div class="main w-full h-full bg-slate-100 rounded-xl overflow-y-scroll relative">
        <div class="p-2 w-fit flex justify-center relative mx-auto">
            <input v-model="keyword" type="search" name="" id="" size="50"
                class="text-xs p-4 tracking-[1px] rounded-sm bg-slate-500 border-none outline-none text-white">
            <button @click="filterPeminjam" class="h-3/6 bg-blue-500 rounded-sm text-white absolute right-3 top-3 w-[15%] mt-1 mr-1">cari</button>
        </div>
        <table class="w-full relative">
            <tr>
                <th>Nama Peminjam</th>
                <th>Jumlah Buku</th>
                <th>Tanggal Kembali</th>
                <th class="w-1/12">Kembali</th>
            </tr>
            <tr v-for="p in peminjam" :key="p.id" class="text-center">
                <td>{{ p.namaLengkap }}</td>
                <td>{{ p.jumlahBuku }}</td>
                <td>{{ p.tanggalKembali }}</td>
                <td><button @click="deletePeminjam(p.id)">&#9989</button></td>
            </tr>
            <div v-if="peminjam.length == 0" class="absolute top-0 left-[30%] w-fit h-96 flex justify-center items-center mx-auto">
                <h2 class="text-5xl font-semibold text-slate-500">Tidak Ada Peminjam</h2>
            </div>
        </table>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    data() {
        return {
            peminjam: [],
            keyword: ''
        }
    },
    methods: {
        getPeminjam() {
            axios.get('http://localhost:8123/api/v1/peminjam/get-all', {
                headers: {
                    "Content-Type": "application/json"
                }
            })
                .then(response => this.peminjam = response.data)
                .catch(err => console.log(err))
        },
        deletePeminjam(id) {
            axios.delete(`http://localhost:8123/api/v1/peminjam/delete/${id}`, {
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(response => {
                console.log(response.data)
                this.peminjam = this.peminjam.filter(peminjam => peminjam.id !== id)
            })
        },
        filterPeminjam() {
            if(this.keyword === '') {
                return this.getPeminjam()
            } else {
                axios.get(`http://localhost:8123/api/v1/peminjam/get-all/peminjam/${this.keyword}`)
                .then(response => {
                    this.peminjam = response.data;
                })
                .catch(err => console.log(err));
            }
        }
    },
    mounted() {
        this.getPeminjam()
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