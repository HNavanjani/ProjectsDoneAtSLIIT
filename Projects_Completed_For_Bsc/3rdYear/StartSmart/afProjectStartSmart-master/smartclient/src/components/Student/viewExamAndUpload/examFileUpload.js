import React from 'react';
import { Fragment, useState } from 'react';
import AssignMessage from '../viewAssignmentAndUpload/assignMessage';
import AssignProgress from '../viewAssignmentAndUpload/assignProgress';
import axios from 'axios';

const ExamFileUpload = () => {
    const  [file, setFile] = useState(''); //use of hooks
    const  [filename, setFilename] = useState('Choose File');
    const [uploadedFile, setUploadedFile] = useState({});
    const [message, setMessage] = useState('');
    const [uploadPercentage, setUploadPercentage] = useState(0);

    const onChange = e => {
        setFile(e.target.files[0]);
        setFilename(e.target.files[0].name);
    };

    const onSubmit = async e => {
        e.preventDefault();
        const formData = new FormData();
        formData.append('file', file);

        try {
            const res = await axios.post('http://localhost:5000/upload', formData, {
                headers:{
                    'Content-Type': 'multipart/form-data'
                },
                onUploadProgress: progressEvent => {
                    setUploadPercentage(parseInt(Math.round((progressEvent.loaded * 100) / progressEvent.total)))

                    //clear percenatge
                    setTimeout(() => setUploadPercentage(0), 10000);
                }
            });
            const { fileName, filePath } = res.data;

            setUploadedFile({fileName, filePath});
            setMessage('File Uploaded');

        }catch (err) {
            if(err.response.status === 500){
                setMessage('There was a problem with the server');
            }else{
                console.log(err.response.data.msg);
            }
        }
    }
    return(
        <Fragment>
        {message ? (<AssignMessage msg={message} />) :null}
    <form onSubmit={onSubmit}>
        <div className="custom-file mb-4">
        <input type="file" className="custom-file-input" id="customFile" onChange={onChange} />
    <label className="custom-file-label" htmlFor="customFile">{filename}</label>
        </div>

        <AssignProgress percentage={uploadPercentage}/>

    <input type="submit" value="Upload" className="btn btn-primary btn-block mt-4" />
        </form>
    {uploadedFile ? ( <div className="row mt-5">
        <div className="col-md-6 m-auto">
        <h3 className="text-center">{ uploadedFile.fileName }</h3>
        <img style={{width: "100%"}} src={uploadedFile.filePath} alt=""/>
        </div>
        </div>
    ) : null}
</Fragment>
)
}
    export default ExamFileUpload;