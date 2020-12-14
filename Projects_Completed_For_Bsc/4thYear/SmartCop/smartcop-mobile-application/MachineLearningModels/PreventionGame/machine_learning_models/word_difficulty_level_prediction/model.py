# Commented out IPython magic to ensure Python compatibility.
import numpy as np
import pandas as pd
from sklearn.svm import SVC

# create df
data = pd.read_csv('data.csv')

data.head()

data.dropna(inplace = True)


# features and target
target = 'overall_label'
features = ['no_of_char', 'syllable_count', 'Frequency_of_occurrence', 'presence_of_ch,sh,th,st,f', 'part_of_speech', 'pronounce_g_j', 'Pronounce_c_k']

# X matrix, y vector
X = data[features]
y = data[target]


#Split dataset into Train and Test 
from sklearn.model_selection import train_test_split
x_train, x_test, y_train, y_test = train_test_split(X, y, test_size=0.2,random_state =1)
print(x_train.shape, y_train.shape, x_test.shape, y_test.shape)


# Apply Support Vector Machine Alogirithm

SVMClassifier = SVC()
SVMClassifier.fit(x_train, y_train)
SVMClassifier.score(x_train, y_train)


import pickle
pickle.dump(SVMClassifier, open('model.pkl', 'wb'))
