/* eslint-disable jsx-a11y/anchor-is-valid */
import { Dropdown, Menu } from "antd"
import BurgerBtn from "../burger-btn"

const MyDropdownMenu = ({
    actions,
}:{
    actions?:string[],
}) => {

    const actionsList = actions?.map((str:string) => {
        return (
            <Menu.Item key={str}>
                <a>{str}</a>
            </Menu.Item>
        )
    })

    const actionsMenu = (
        <Menu>
            {actionsList}
        </Menu>)

    return (
        <Dropdown overlay={actionsMenu} placement="bottomLeft" trigger={["click"]} className="actions-menu">
            <a>
                <BurgerBtn/>
            </a>
        </Dropdown>
    )
}


export default MyDropdownMenu