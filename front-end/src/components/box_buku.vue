<template>
    <div class="h-fit w-11/12 mx-auto mt-3 p-2 bg-white rounded-2xl flex items-center relative">
        <div class="h-9 w-9 rounded-full absolute top-2 left-2 flex justify-center items-center" :class="whatKategory">
            <div class="h-5 w-5 rounded-full bg-white"></div>
        </div>
        <BookIcon class="text-9xl flex-shrink-0" />
        <div class="h-full w-full flex flex-col gap-1 justify-center text-sm">
            <span>
                <h1>Judul Buku</h1>
                <p>{{ judul }}</p>
            </span>
            <span>
                <h1>Kode Buku</h1>
                <p>{{ kode }}</p>
            </span>
            <span>
                <h1>Kategori</h1>
                <p>{{ kategori }}</p>
            </span>
            <span>
                <h1>Tahun Rilis</h1>
                <p>{{ tahunRilis }}</p>
            </span>
            <span>
                <h1>Deskripsi</h1>
                <p class="text-xs leading-5">{{ deskripsi }}</p>
            </span>
        </div>
    </div>
</template>
<script>
import BookIcon from 'vue-ionicons/dist/md-book.vue'

export default {
    props: {
        judul: String,
        kode: String,
        kategori: String,
        tahunRilis: String,
        deskripsi: String
    },
    data() {
        return {
            classKategori: ''
        }
    },
    components: {
        BookIcon
    },
    computed: {
        whatKategory() {
            switch (this.kategori) {
                case 'hiburan':
                case 'Hiburan':
                    this.classKategori = 'hiburan'
                    break;
                case 'berita':
                case 'Berita':
                    this.classKategori = 'berita'
                    break;
                default:
                    this.classKategori = 'pendidikan'
                    break;
            }
            return this.classKategori
        }
    }
}
</script>

<style scoped>
h1 {
    font-weight: bolder;
}

p {
    width: 100%;
    background: #f5f5f5;
    padding-left: 5px;
    border-radius: 2px;
}

span {
    letter-spacing: 2px;
}

.pendidikan {
    background-color: #ff8a05;
}

.hiburan {
    background-color: #00b3f4;
}

.berita {
    background-color: #a80000;
}
</style>