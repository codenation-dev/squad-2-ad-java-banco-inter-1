import React from 'react'
import { makeStyles } from '@material-ui/core/styles'
import Table from '@material-ui/core/Table'
import TableBody from '@material-ui/core/TableBody'
import TableCell from '@material-ui/core/TableCell'
import TableContainer from '@material-ui/core/TableContainer'
import TableHead from '@material-ui/core/TableHead'
import TableRow from '@material-ui/core/TableRow'
import Paper from '@material-ui/core/Paper'

const useStyles = makeStyles({
  table: {
    minWidth: 650
  }
});

function createData(id, errorType, logDescription, numEvents) {
  return { id, errorType, logDescription, numEvents }
}

const rows = [
  createData(1, 'Error', 159, 6.0),
  createData(2, 'Error', 237, 9.0),
  createData(3, 'Warning', 262, 16.0),
  createData(4, 'Debug', 305, 3.7),
  createData(5, 'Error', 356, 16.0)
]

export default function SimpleTable() {
  const classes = useStyles();

  return (
    <TableContainer component={Paper}>
      <Table className={classes.table} aria-label='simple table'>
        <TableHead>
          <TableRow>
            <TableCell>Error Type</TableCell>
            <TableCell align='left'>Log Description</TableCell>
            <TableCell align='left'>Number of Events</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map(row => {
            return (
              <TableRow key={row.id}>
                <TableCell align='left'>{row.errorType}</TableCell>
                <TableCell align='left'>{row.logDescription}</TableCell>
                <TableCell align='left'>{row.numEvents}</TableCell>
              </TableRow>
            )
          })}
        </TableBody>
      </Table>
    </TableContainer>
  );
}