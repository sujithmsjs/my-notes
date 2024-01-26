import axios from "axios";
import { baseURL } from "./Env";

export const instance = axios.create({
  baseURL,
  timeout: 2000,
  headers: { "X-Custom-Header": "foobar", name: "Sujith" }
});

export const handleAxiosError = (error) => {
  if (axios.isAxiosError(error)) {
    if (error.response) {
      const errorObj = {};
      if (error.response) {
        errorObj.type = "Response Error";
        errorObj.status = error.response.status;
        errorObj.data = error.response.data;
        errorObj.url = error.response.request.responseURL;
      } else if (error.request) {
        errorObj.type = "Request Error";
        errorObj.request = error.request;
      } else {
        errorObj.type = "Setup Error";
        errorObj.message = error.message;
      }
      console.error("Axios Error:", errorObj);
    } else {
      console.error("Request failed and no response received.");
    }
  } else {
    console.error("General error:", error.message);
  }
};
