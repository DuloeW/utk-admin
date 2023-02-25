<template>
    <div class="h-2/5 w-11/12 mx-auto mt-3 p-2 bg-white rounded-2xl flex items-center">
        <HumanProfile class="text-9xl flex-shrink-0"/>
        <div class="h-full w-full flex flex-col gap-1 justify-center text-sm">
           <span>
            <h1>Nama Panjang</h1>
            <p>{{ nama }}</p>
           </span>
           <span>
            <h1>NISN</h1>
            <p>{{ nisn }}</p>
           </span>
           <span>
            <h1>Tanggal Pinjam</h1>
            <p>{{ tanggal_pin }}</p>
           </span>
           <span>
            <h1>Tanggal Kembali</h1>
            <p>{{ tanggal_kem }}</p>
           </span>
           <span>
            <h1>Jumlah Buku</h1>
            <p>{{ buku }}</p>
           </span>
        </div>
    </div>
</template>
<script>
import HumanProfile from 'vue-ionicons/dist/md-person.vue'

export default {
    components: {
        HumanProfile
    },
    props: ['nama', 'nisn', 'tanggal_pin', 'tanggal_kem', 'buku']
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
</style>