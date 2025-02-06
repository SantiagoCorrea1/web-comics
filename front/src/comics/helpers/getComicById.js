export const getComicById = async( urlName ) => {

    const url = `http://localhost:8080/comics/${urlName}`
    const resp = await fetch(url);

    const data = await resp.json();

    return data
}