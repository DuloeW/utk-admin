<template>
    <div class="main w-full h-full bg-slate-100 rounded-xl overflow-y-scroll relative">
        <div class="p-2 w-fit flex justify-center relative mx-auto">
            <input type="search" name="" id="" size="50"
                class="text-xs p-4 tracking-[1px] rounded-sm bg-slate-500 border-none outline-none text-white">
            <button class="h-3/6 bg-blue-500 rounded-sm text-white absolute right-3 top-3 w-[15%] mt-1 mr-1">cari</button>
        </div>
        <table class="w-full">
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
                <td><input type="checkbox" name="" id=""></td>
            </tr>

        </table>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    data() {
        return {
            peminjam: []
        }
    },
    methods: {
        async getPeminjam() {
            await fetch('http://localhost:5174/api/v1/peminjam/get-all', {
                mode: 'no-cors',
                method: 'GET',
                headers: {
                    'Access-Control-Allow-Origin': '*',
                    'Content-Type': 'application/json',
                }
            }).then(response => response.json())
            .then(data => console.log(data))
            .catch(err => console.log(err))
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