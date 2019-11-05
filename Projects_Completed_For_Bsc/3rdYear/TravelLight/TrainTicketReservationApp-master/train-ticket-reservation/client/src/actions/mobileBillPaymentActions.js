import axios from "axios";
import { ADD_MOBILEBILLPAYMENT } from "./types";

//Add mobile bill payment
export const addMobileBillPayment = mobileBillPayment => dispatch => {
  axios.post("/api/mobileBillPayment", mobileBillPayment).then(res =>
    dispatch({
      type: ADD_MOBILEBILLPAYMENT,
      payload: res.data
    })
  );
};
