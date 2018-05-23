<?xml version="1.0" encoding="windows-1251"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="windows-1251"/>
    <xsl:template match="/Booking">
        <style type="text/css">
            th {
            background-color: #B3F16A;

            }
            tr, td {
            background-color: white;
            border-style: solid;
            border-color: grey;
            border-width: 1px;
            empty-cells: show;
            vertical-align: center;
            text-align: center;
            font-size: 12;
            }

        </style>
        <table>
            <tr>
                <th>ID ������������</th>
                <th>Email</th>
                <th>������</th>
                <th>���</th>
                <th>�������</th>
                <th>��������</th>
                <th>������ ����������</th>
                <th>����� ��������</th>
                <th>ID �����</th>
                <th>��������</th>
                <th>���</th>
                <th>���������� �����</th>
                <th>������</th>
                <th>�����</th>
                <th>�����</th>
                <th>����� ����</th>
                <th>���������� Email</th>
                <th>����� �������� �����</th>
                <th>ID �������</th>
                <th>�������� �������</th>
                <th>����� �������</th>
                <th>����������� (�������)</th>
                <th>��������</th>
                <th>���������</th>
                <th>ID ��������������</th>
                <th>���� ��������������</th>
                <th>���� ������</th>
                <th>���� �������</th>
                <th>�������� ��������</th>
                <th>������ �������</th>
                <th>��������������� �������������</th>
            </tr>
            <xsl:for-each select="/Booking/Users/User">
                <xsl:if test="count(Hotels/Hotel) = 0">
                   <tr>
                       <td><xsl:value-of select="UserId"/></td>
                       <td><xsl:value-of select="Email"/></td>
                       <td><xsl:value-of select="Password"/></td>
                       <td><xsl:value-of select="FirstName"/></td>
                       <td><xsl:value-of select="LastName"/></td>
                       <td><xsl:value-of select="MiddleName"/></td>
                       <td><xsl:value-of select="Country"/></td>
                       <td><xsl:value-of select="PhoneNumber"/></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                       <td></td>
                   </tr>
                </xsl:if>
                <xsl:for-each select="Hotels/Hotel">
                    <xsl:for-each select="Rooms/Room">
                        <xsl:if test="count(Reservations/Reservation) = 0">
                            <tr>
                                <td><xsl:value-of select="../../../../UserId"/></td>
                                <td><xsl:value-of select="../../../../Email"/></td>
                                <td><xsl:value-of select="../../../../Password"/></td>
                                <td><xsl:value-of select="../../../../FirstName"/></td>
                                <td><xsl:value-of select="../../../../LastName"/></td>
                                <td><xsl:value-of select="../../../../MiddleName"/></td>
                                <td><xsl:value-of select="../../../../Country"/></td>
                                <td><xsl:value-of select="../../../../PhoneNumber"/></td>
                                <td><xsl:value-of select="../../HotelId"/></td>
                                <td><xsl:value-of select="../../Name"/></td>
                                <td><xsl:value-of select="../../Type"/></td>
                                <td><xsl:value-of select="../../StarRating"/></td>
                                <td><xsl:value-of select="../../Country"/></td>
                                <td><xsl:value-of select="../../City"/></td>
                                <td><xsl:value-of select="../../Street"/></td>
                                <td><xsl:value-of select="../../HouseNumber"/></td>
                                <td><xsl:value-of select="../../ContactEmail"/></td>
                                <td><xsl:value-of select="../../PhoneNumber"/></td>
                                <td><xsl:value-of select="RoomId"/></td>
                                <td><xsl:value-of select="RoomName"/></td>
                                <td><xsl:value-of select="RoomFactNumber"/></td>
                                <td><xsl:value-of select="PeopleAmount"/></td>
                                <td><xsl:value-of select="Description"/></td>
                                <td><xsl:value-of select="Cost"/></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        </xsl:if>
                        <xsl:for-each select="Reservations/Reservation">
                            <tr>
                                <td><xsl:value-of select="../../../../../../UserId"/></td>
                                <td><xsl:value-of select="../../../../../../Email"/></td>
                                <td><xsl:value-of select="../../../../../../Password"/></td>
                                <td><xsl:value-of select="../../../../../../FirstName"/></td>
                                <td><xsl:value-of select="../../../../../../LastName"/></td>
                                <td><xsl:value-of select="../../../../../../MiddleName"/></td>
                                <td><xsl:value-of select="../../../../../../Country"/></td>
                                <td><xsl:value-of select="../../../../../../PhoneNumber"/></td>
                                <td><xsl:value-of select="../../../../HotelId"/></td>
                                <td><xsl:value-of select="../../../../Name"/></td>
                                <td><xsl:value-of select="../../../../Type"/></td>
                                <td><xsl:value-of select="../../../../StarRating"/></td>
                                <td><xsl:value-of select="../../../../Country"/></td>
                                <td><xsl:value-of select="../../../../City"/></td>
                                <td><xsl:value-of select="../../../../Street"/></td>
                                <td><xsl:value-of select="../../../../HouseNumber"/></td>
                                <td><xsl:value-of select="../../../../ContactEmail"/></td>
                                <td><xsl:value-of select="../../../../PhoneNumber"/></td>
                                <td><xsl:value-of select="../../RoomId"/></td>
                                <td><xsl:value-of select="../../RoomName"/></td>
                                <td><xsl:value-of select="../../RoomFactNumber"/></td>
                                <td><xsl:value-of select="../../PeopleAmount"/></td>
                                <td><xsl:value-of select="../../Description"/></td>
                                <td><xsl:value-of select="../../Cost"/></td>
                                <td><xsl:value-of select="ReservationId"/></td>
                                <td><xsl:value-of select="ReservationDate"/></td>
                                <td><xsl:value-of select="CheckInDate"/></td>
                                <td><xsl:value-of select="CheckOutDate"/></td>
                                <td><xsl:value-of select="TotalCost"/></td>
                                <td><xsl:value-of select="PaymentStatus"/></td>
                                <td><xsl:value-of select="UserId"/></td>
                            </tr>
                        </xsl:for-each>
                    </xsl:for-each>
                </xsl:for-each>
            </xsl:for-each>

        </table>

    </xsl:template>


</xsl:stylesheet>