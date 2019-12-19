import React, { useEffect } from 'react'
import Table from '@material-ui/core/Table'
import TableBody from '@material-ui/core/TableBody'
import TableCell from '@material-ui/core/TableCell'
import TableHead from '@material-ui/core/TableHead'
import TableRow from '@material-ui/core/TableRow'
import Title from './../Title/Title'

// data that will be consumed by the API
import data from './data.json'

function createData(id, environment, level, status, description, createdDate) {
  return { id, environment, level, status, description, createdDate }
}

const rows = [
  createData(0, 'Environment goes here', 'Level goes here', 'Status goes here', 'Description goes here', 'Created date goes here'),
  createData(1, 'Environment goes here', 'Level goes here', 'Status goes here', 'Description goes here', 'Created date goes here'),
  createData(2, 'Environment goes here', 'Level goes here', 'Status goes here', 'Description goes here', 'Created date goes here'),
  createData(3, 'Environment goes here', 'Level goes here', 'Status goes here', 'Description goes here', 'Created date goes here'),
  createData(4, 'Environment goes here', 'Level goes here', 'Status goes here', 'Description goes here', 'Created date goes here')
]

// populate the rows from the request. For each event, a new createData will be pushed to the rows
// then map the rows accordingly

export default function Orders() {

  useEffect(() => {
    console.log('data: ', data)
  }, [])

  return (
    <React.Fragment>
      <Title>Recent Orders</Title>
      <Table size="small">
        <TableHead>
          <TableRow>
            <TableCell>Environment</TableCell>
            <TableCell>Level</TableCell>
            <TableCell>Status</TableCell>
            <TableCell>Description</TableCell>
            <TableCell align="right">Created date</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map(row => (
            <TableRow key={row.id}>
              <TableCell>{row.environment}</TableCell>
              <TableCell>{row.level}</TableCell>
              <TableCell>{row.status}</TableCell>
              <TableCell>{row.description}</TableCell>
              <TableCell align="right">{row.createdDate}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </React.Fragment>
  )
}