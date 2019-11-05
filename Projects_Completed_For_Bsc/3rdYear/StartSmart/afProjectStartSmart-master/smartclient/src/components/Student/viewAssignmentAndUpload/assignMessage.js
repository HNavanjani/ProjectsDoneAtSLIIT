import React from 'react';
import PropTypes from 'prop-types';

const AssignMessage = ({msg}) => {
    return(
        <div className="alert alert-info alert-dismissible fade show" role="alert">
        {msg}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    </div>
)
}
AssignMessage.propTypes = {
    msg: PropTypes.string.isRequired
}

export default AssignMessage;