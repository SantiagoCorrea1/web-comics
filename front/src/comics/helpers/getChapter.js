export const getChapter = async (comic, chapter) => {
const url = `http://localhost:8080/comics/${comic}/chapter/${chapter}`


const resp = await fetch(url);
const data = await resp.json();

return data;
}