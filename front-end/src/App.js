import { useState } from 'react'
import TextBox from './components/TextBox'
import Arrows from './components/Arrows'
import Button from './components/Button'
import axios from 'axios'

const App = () => {
  
  const [inputNumberType, setInputNumberType] = useState('Roman')
  const [outputNumberType, setOutputNumberType] = useState('Integer')
  const [numberToConvert, setNumberToConvert] = useState('')
  const [convertedNumber, setConvertedNumber] = useState('')


  const convert = async () => {
    console.log('trainsalte')
    const data = {
      number: numberToConvert
    }
    const response = await axios.get(`http://146.190.227.11:8080/${inputNumberType === 'Roman' ? '2int' : '2roman'}`, {
      params : data
    })
    console.log('response', response)
    setConvertedNumber(response.data)
  }

  const handleClick = () => {
    setInputNumberType(outputNumberType)
    setNumberToConvert(convertedNumber)
    setOutputNumberType(inputNumberType)
    setConvertedNumber(numberToConvert)
  }

  return (
    <div className="app">
      
        <>
          <TextBox
            style="input"
            
            selectedNumberType={inputNumberType}
            setNumberToConvert={setNumberToConvert}
            numberToConvert={numberToConvert}
            setConvertedNumber={setConvertedNumber}
          />
          <div className="arrow-container" onClick={handleClick} >
            <Arrows />
          </div>
          <TextBox
            style="output"
           
            selectedNumberType={outputNumberType}
            convertedNumber={convertedNumber}
          />
          <div className="button-container" onClick={convert} >
            <Button />
          </div>
        </>
     
      
    </div>
  )
}

export default App
