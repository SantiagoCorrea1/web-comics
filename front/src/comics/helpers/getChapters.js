export const getChapters = async( comic ) => {

    const url = `http://localhost:8080/comics/${comic}/chapters`
    const resp = await fetch(url);

    const data = await resp.json();

    return data;
}