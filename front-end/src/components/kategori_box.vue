<template>
    <div class="h-fit w-fit p-2 bg-slate-800 flex flex-col gap-4 rounded-md">
        <span class="w-6 h-6 rounded-full bg-orange-400">
            <h3>P</h3>
            <span>
                <p>Pendidikan</p>
            </span>
        </span>
        <span class="w-6 h-6 rounded-full bg-blue-500">
            <h3>H</h3>
            <span>
                <p>Hiburan</p>
            </span>
        </span>
        <span class="w-6 h-6 rounded-full bg-red-700">
            <h3>B</h3>
            <span>
                <p>Berita</p>
            </span>
        </span>
    </div>
</template>
<style scoped>
span {
    display: flex;
    justify-content: center;
    align-items: center;
    position: relative;
    z-index: 1;
}
span:hover {
    cursor: pointer;
}

span:hover span {
    position: absolute;
    padding: 5px 20px 5px 20px;
    background: #1E293B;
    color: white;
    font-weight: bolder;
    right: 40px;
    opacity: 1;
    border-radius: 4px;
}

span span {
    position: absolute;
    padding: 5px 20px 5px 20px;
    background: #1E293B;
    color: white;
    font-weight: bolder;
    right: -100px;
    opacity: 0;
    border-radius: 4px;
    transition: .5s ease-in-out;
}

h3 {
    font-weight: bolder;
    color: white;
}</style>