<template>
    <div class="h-fit w-2/4 bg-slate-500 flex flex-col p-2 rounded-md">
        <div class="data-book">
            <label for="">Judul Buku</label>
            <span>
                <p>Muninem</p>
            </span>
        </div>
        <div class="data-book">
            <label for="">Kode Buku</label>
            <span>
                <p>9381</p>
            </span>
        </div>
        <div class="data-book">
            <label for="">Kategori</label>
            <span>
                <p>Pendidikan</p>
            </span>
        </div>
        <div class="data-book">
            <label for="">Tahun Rilis</label>
            <span>
                <p>12/10/2005</p>
            </span>
        </div>
        <div class="data-book">
            <label for="">Deskripsi</label>
            <span class="">
                <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Doloremque et molestiae, nisi fugit veniam iste voluptatem cumque, nam debitis non repudiandae nobis ipsa rerum dolore explicabo laborum tenetur perferendis magni quae nihil earum doloribus! Sed non rem accusamus vitae veritatis, explicabo provident laborum accusantium corporis saepe voluptate tenetur commodi ad, fuga nesciunt cupiditate impedit numquam nisi repudiandae odit quam odio? Iste, eos aliquid, temporibus fuga quaerat sed perspiciatis quam iusto rem dicta tenetur quod ullam qui, voluptatibus nam dolores reiciendis dolore distinctio numquam cumque? Recusandae amet earum minus blanditiis autem rerum, ullam reprehenderit commodi, minima quam tempore reiciendis! Dolores, neque.</p>
            </span>
        </div>
    </div>
</template>
<script>
export default {

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