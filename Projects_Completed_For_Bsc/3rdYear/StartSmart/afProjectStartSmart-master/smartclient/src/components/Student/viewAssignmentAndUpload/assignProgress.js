import React from 'react';
import PropTypes from 'prop-types';

const AssignProgress = ({percentage}) => {
    return(
        <div className="progress">
        <div
            className="progress-bar bg-success"
            role="progressbar"
            style={{ width: `${percentage}%`}}
                >
                {percentage}%
        </div>
        </div>
)
};
AssignProgress.propTypes = {
    percentage: PropTypes.number.isRequired
}
export default AssignProgress;