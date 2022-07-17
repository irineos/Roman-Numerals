import NumberType from './NumberType'

const TextBox = ({
  style,
  selectedNumberType,
  setNumberToConvert,
  numberToConvert,
  convertedNumber,
  setConvertedNumber,
}) => {

  const handleClick = () => {
    setNumberToConvert('')
    setConvertedNumber('')
  }
  return (
    <div className={style}>
      <NumberType
        style={style}
        selectedNumberType={selectedNumberType}
      />
      <textarea
        disabled={style === 'output'}
        className={style}
        placeholder={style === 'input' ? (selectedNumberType === 'Roman' ? 'Enter Roman Number' : 'Enter Integer') : (selectedNumberType === 'Roman' ? 'Roman Number' : 'Integer')}
        onChange={(e) => setNumberToConvert(e.target.value)}
        value={style === 'input' ? numberToConvert : convertedNumber}
      />
      {style === 'input' && (
        <div className="delete" onClick={handleClick}>
          ˟
        </div>
      )}
    </div>
  )
}

export default TextBox
