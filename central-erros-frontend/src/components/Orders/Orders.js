import React, { useEffect, useState, memo } from 'react'
import Table from '@material-ui/core/Table'
import TableBody from '@material-ui/core/TableBody'
import TableCell from '@material-ui/core/TableCell'
import TableHead from '@material-ui/core/TableHead'
import TableRow from '@material-ui/core/TableRow'
import Title from './../Title/Title'

function Orders({ innerData }) {
  const [row, setRow] = useState('')
  
  useEffect(() => {
    const newRow = []
    function mapValues () {
      innerData.map((item, index) => {
        const obj = {
          id: item.id,
          environment: item.environment,
          level: item.level,
          status: item.status,
          description: item.description
        }
        newRow.push(obj)
      })
    }

    if (innerData) {
      mapValues()
      setRow(newRow)
    }
  }, [innerData])

  useEffect(() => {
    console.log('row: ', row)
  }, [row])

  return (
    <React.Fragment>
      <Title>Recent Orders</Title>
      <Table size="small">
        <TableHead>
          <TableRow>
            <TableCell>Id</TableCell>
            <TableCell>Environment</TableCell>
            <TableCell>Level</TableCell>
            <TableCell>Status</TableCell>
            <TableCell>Description</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {row && row.map(item => (
            <TableRow key={item.id}>
              <TableCell>{item.id}</TableCell>
              <TableCell>{item.environment}</TableCell>
              <TableCell>{item.level}</TableCell>
              <TableCell>{item.status}</TableCell>
              <TableCell>{item.description}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </React.Fragment>
  )
}

export default memo(Orders)