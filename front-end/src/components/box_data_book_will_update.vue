<template>
    <div class="h-fit w-2/4 bg-slate-500 flex flex-col p-2 rounded-md">
        <form class="flex flex-col">
            <div class="data-book">
                <Label>Judul Buku</Label>
                <input type="text" maxlength="50" minlength="10" required>
            </div>
            <div class="data-book">
                <Label>Kode Buku</Label>
                <input type="text" maxlength="5" minlength="5" required>
            </div>
            <div class="data-book">
                <label for="">Kategori</label>
                <select name="" id="">
                    <option value="pendidikan">Pendidikan</option>
                    <option value="hiburan" selected>Hiburan</option>
                    <option value="berita">Berita</option>
                </select>
            </div>
            <div class="data-book">
                <Label>Tahun Rilis</Label>
                <input type="date" required>
            </div>
            <div class="data-book">
                <Label>Deskripsi</Label>
                <textarea name="" id="" cols="30" rows="10" required></textarea>
            </div>
            <div class="w-full h-full flex justify-around items-center mt-2">
                <button class="bg-green-700 text-white">Kirim</button>
                <input type="reset" value="Hapus" class="bg-red-700 text-white">
            </div>
        </form>
    </div>
</template>
<style scoped>
.data-book {
    display: flex;
    flex-direction: column;
    padding: 5px;
    background-color: #2a2a2a;
    margin-top: 5px;
    border-radius: 5px;
}

label {
    color: white;
    font-weight: bolder;
    letter-spacing: 1.5px;
}

input,
select,
textarea,
button {
    border: none;
    outline: none;
    font-size: 13.5px;
    padding: 2px;
    border-radius: 5px;
}</style>