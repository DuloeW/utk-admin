<template>
    <div class="w-10/12 h-10/12 flex flex-col m-3 gap-9">
        <div class="w-full flex gap-5">
            <BoxShowPeminjam :size="sizePeminjam"/>
            <BoxShowBook :size="sizeBook" />
        </div>
        <TablePeminjamMain/>
    </div>
</template>
<script>
import axios from 'axios';
import BoxShowPeminjam from '../components/box_show_peminjam.vue'
import BoxShowBook from '../components/box_show_book.vue'
import TablePeminjamMain from '../components/data_peminjam_on_main.vue'

export default {
    data() {
        return {
            sizeBook: '0',
            sizePeminjam: '0',
            sizeOldPeminjam : ''
        }
    },
    components: {
        BoxShowPeminjam,
        BoxShowBook,
        TablePeminjamMain
    },
    methods: {
        getSizeBooks() {
            axios.get('http://localhost:8123/api/v1/buku/get-size', {
                headers: {
                    "Content-Type": "application/json"
                }
            }).then(response => this.sizeBook = response.data.size)
        },
        getSizePeminjam() {
            axios.get('http://localhost:8123/api/v1/peminjam/get-size', {
                headers: {
                    "Content-Type": "application/json"
                }
            })
            .then(response => this.sizePeminjam = response.data.size)
            .catch(err => console.log(err))
        }
    },
    mounted() {
        this.getSizeBooks()
        this.getSizePeminjam()
    },
}
</script>