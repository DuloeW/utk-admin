<template>
    <div class="h-fit w-2/4 bg-slate-500 flex flex-col p-2 rounded-md">
        <div class="data-book">
            <label for="">Judul Buku</label>
            <span>
                <p>{{ judul }}</p>
            </span>
        </div>
        <div class="data-book">
            <label for="">Kode Buku</label>
            <span>
                <p>{{ kode }}</p>
            </span>
        </div>
        <div class="data-book">
            <label for="">Kategori</label>
            <span>
                <p>{{ kategori }}</p>
            </span>
        </div>
        <div class="data-book">
            <label for="">Tahun Rilis</label>
            <span>
                <p>{{ tahun }}</p>
            </span>
        </div>
        <div class="data-book">
            <label for="">Deskripsi</label>
            <span class="">
                <p>{{ deskripsi }}</p>
            </span>
        </div>
    </div>
</template>
<script>
export default {
    props: {
        judul: String,
        kode: String,
        kategori: String,
        tahun: String,
        deskripsi: String
    }
}
</script>
<style scoped>
.data-book {
    display: flex;
    flex-direction: column;
    padding: 10px;
    background-color: #2a2a2a;
    margin-top: 5px;
    border-radius: 5px;
}
label {
    color: white;
    font-weight: bolder;
    letter-spacing: 1.5px;
}
p{
    color: white;
    font-size: small;
    letter-spacing: 2px;
}
</style>