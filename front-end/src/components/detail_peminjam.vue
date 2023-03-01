<template>
    <div class="w-11/12 h-11/12">
        <div class=" w-full h-full bg-slate-200 rounded-xl overflow-y-scroll">
            <BoxPeminjam v-for="p in peminjam" :nama="p.namaLengkap" :nisn="p.nisn" :tanggal_pin="p.tanggalPinjam" :tanggal_kem="p.tanggalKembali" :buku="p.jumlahBuku" class="box-peminjam"/>
        </div>
    </div>
</template>
<script>
import BoxPeminjam from '../components/box_peminjam.vue';
import axios from 'axios';
export default {
    components: {
        BoxPeminjam,
    },
    data() {
        return {
            peminjam: []
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
        }
    },
    mounted() {
        this.getPeminjam()
    }
};
</script>
<style scoped>
.box-peminjam {
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