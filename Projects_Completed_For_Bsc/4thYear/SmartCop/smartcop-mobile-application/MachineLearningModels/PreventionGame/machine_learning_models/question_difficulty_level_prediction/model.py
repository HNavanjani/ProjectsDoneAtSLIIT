import pandas as pd
from sklearn.linear_model import LogisticRegression

# create df
train = pd.read_csv('PlayerData_1.csv')

# drop null values
train.dropna(inplace=True)

# features and target
target = 'difficultyLevel'
features = ['scoreLevel', 'timeLevel']

# X matrix, y vector
X = train[features]
y = train[target]

# model 
model = LogisticRegression()
model.fit(X, y)
model.score(X,y)

train.head()


import pickle
pickle.dump(model, open('model.pkl', 'wb'))