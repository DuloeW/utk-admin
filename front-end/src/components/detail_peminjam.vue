<template>
    <div class="w-11/12 h-11/12">
        <div class=" w-full h-full bg-slate-200 rounded-xl overflow-y-scroll">
            <BoxPeminjam :nama="nama" :nisn="nisn" :tanggal_pin="tanggal_pin" :tanggal_kem="tanggal_kem" :buku="buku" class="box-peminjam"/>
            <BoxPeminjam :nama="nama" :nisn="nisn" :tanggal_pin="tanggal_pin" :tanggal_kem="tanggal_kem" :buku="buku" class="box-peminjam"/>
            <BoxPeminjam :nama="nama" :nisn="nisn" :tanggal_pin="tanggal_pin" :tanggal_kem="tanggal_kem" :buku="buku" class="box-peminjam"/>
            <BoxPeminjam :nama="nama" :nisn="nisn" :tanggal_pin="tanggal_pin" :tanggal_kem="tanggal_kem" :buku="buku" class="box-peminjam"/>
            <BoxPeminjam :nama="nama" :nisn="nisn" :tanggal_pin="tanggal_pin" :tanggal_kem="tanggal_kem" :buku="buku" class="box-peminjam"/>
            <BoxPeminjam :nama="nama" :nisn="nisn" :tanggal_pin="tanggal_pin" :tanggal_kem="tanggal_kem" :buku="buku" class="box-peminjam"/>
        </div>
    </div>
</template>
<script>
import BoxPeminjam from '../components/box_peminjam.vue';

export default {
    components: {
        BoxPeminjam,
    },
    data() {
        return {
            nama: 'I Putu Bayu Gelgel Wiyantara',
            nisn: '192928192921083',
            tanggal_pin: '12/09/2005',
            tanggal_kem: '19/09/2005',
            buku: '4'
        }
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