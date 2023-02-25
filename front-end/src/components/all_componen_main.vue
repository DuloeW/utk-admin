<template>
    <div class="w-10/12 h-10/12 flex flex-col m-3 gap-9">
        <div class="w-full flex gap-5">
            <BoxShowPeminjam />
            <BoxShowBook />
        </div>
        <TablePeminjamMain/>
    </div>
</template>
<script>
import BoxShowPeminjam from '../components/box_show_peminjam.vue'
import BoxShowBook from '../components/box_show_book.vue'
import TablePeminjamMain from '../components/data_peminjam_on_main.vue'

export default {
    components: {
        BoxShowPeminjam,
        BoxShowBook,
        TablePeminjamMain
    }
}
</script>