import React from 'react';
import {useParams} from "react-router-dom";
const Help = () => {

  let { id } = useParams();

  return (
    <div className="bg-primary" style={{height:"1000rem"}}>
      <h1 className="text-danger text-center">HELP</h1>
      <p className="text-light text-center">
        {id}
      </p>
    </div>
  );
};
  
export default Help;