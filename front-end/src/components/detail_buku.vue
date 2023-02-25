<template>
    <div class="w-11/12 h-11/12">
        <div class=" w-full h-full bg-slate-200 rounded-xl overflow-y-scroll relative">
            <BoxBook :judul="judul" :kode="kode" :kategori="kategori" :tahunRilis="tahunRilis" :deskripsi="deskripsi" class="box-buku"/>
            <BoxBook :judul="judul" :kode="kode" :kategori="'pendidikan'" :tahunRilis="tahunRilis" :deskripsi="deskripsi2" class="box-buku"/>
            <BoxBook :judul="judul" :kode="kode" :kategori="'Berita'" :tahunRilis="tahunRilis" :deskripsi="deskripsi" class="box-buku"/>
            <BoxBook :judul="judul" :kode="kode" :kategori="'pendidikan'" :tahunRilis="tahunRilis" :deskripsi="deskripsi2" class="box-buku"/>
            <KategoriBox class="fixed right-4 top-3"/>
        </div>
    </div>
</template>
<script>
import BoxBook from '../components/box_buku.vue';
import KategoriBox from '../components/kategori_box.vue'
export default {
    components: {
        BoxBook,
        KategoriBox
    },
    data() {
        return {
            judul: 'Memakan Teman',
            kode: '01Jka',
            kategori: 'Hiburan',
            tahunRilis: '12/09/2005',
            deskripsi: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Earum necessitatibus placeat reiciendis deleniti ratione aperiam sint corrupti ipsum? Quia ipsam corporis, magnam perspiciatis atque nihil incidunt officia perferendis quisquam minus voluptatibus architecto rerum veritatis tenetur corrupti veniam error labore dolorum ducimus consectetur? Non asperiores ad, laborum distinctio pariatur libero? Nesciunt, dignissimos et! Rem aperiam quisquam harum optio adipisci ipsam, error voluptatum deserunt placeat atque doloribus unde iure inventore id tenetur fuga ut! Quo rem ipsa dicta excepturi earum ducimus doloremque id quam harum nulla alias perferendis voluptatibus eum, vel ipsum suscipit cumque explicabo veniam tenetur labore assumenda saepe minima et.',
            deskripsi2: 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Earum necessitatibus placeat reiciendis deleniti ratione aperiam sint corrupti ipsum? Quia ipsam corporis, magnam perspiciatis atque nihil incidunt officia perferendis quisquam minus voluptatibus architecto rerum veritatis tenetur corrupti veniam error labore dolorum ducimus consectetur? Non asperiores ad, laborum'
        }
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